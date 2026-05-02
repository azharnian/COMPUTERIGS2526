const dashboardState = window.__DASHBOARD__ || {};
const initialTanks = dashboardState.initialTanks || [];
const tankIds = dashboardState.tankIds || [];
const dashboardUrl = `/api/dashboard/data?tanks=${encodeURIComponent(tankIds.join(','))}`;

const sensors = [
    { key:'suhu', label:'Temp', unit:'°C', color:'orange', limit:35 },
    { key:'ph', label:'pH', unit:'', color:'lime', min:5.5, max:7.5 },
    { key:'h2s', label:'H2S', unit:'ppm', color:'red', limit:10 },
    { key:'co', label:'CO', unit:'ppm', color:'yellow', limit:150 },
    { key:'co2', label:'CO2', unit:'ppm', color:'cyan', limit:800 },
    { key:'ch4', label:'CH4', unit:'ppm', color:'magenta', limit:400 }
];

const charts = {};

function format(value) {
    if (value === null || value === undefined || Number.isNaN(Number(value))) return '--';
    return Number(value).toFixed(1);
}

function isAlarm(sensor, value) {
    if (value === null || value === undefined || Number.isNaN(Number(value))) return false;

    const numericValue = Number(value);
    if (sensor.min !== undefined && numericValue < sensor.min) return true;
    if (sensor.max !== undefined && numericValue > sensor.max) return true;
    if (sensor.limit !== undefined && numericValue > sensor.limit) return true;

    return false;
}

function gasStatus(data) {
    if (!data || data.co2 === null || data.co2 === undefined) {
        return { text:'UNKNOWN', className:'gas gas-unknown', level:0 };
    }

    const co2 = Number(data.co2);
    const level = Math.min(100, Math.max(5, co2 / 10));

    if (co2 > 800) return { text:'DANGER', className:'gas gas-danger', level };
    if (co2 > 600) return { text:'WARNING', className:'gas gas-warning', level };
    return { text:'NORMAL', className:'gas gas-normal', level };
}

function renderStaticParts(index) {
    document.getElementById(`legend-${index}`).innerHTML = sensors.map(sensor => `
        <span class="legend-item">
            <span class="dot" style="background:${sensor.color}"></span>
            ${sensor.label}
        </span>
    `).join('');

    document.getElementById(`grid-${index}`).innerHTML = sensors.map(sensor => `
        <div class="card" id="card-${sensor.key}-${index}">
            ${sensor.label}<br>
            <span class="value" id="${sensor.key}-${index}">--</span>
        </div>
    `).join('');
}

function createChart(index) {
    charts[index] = new Chart(document.getElementById(`chart-${index}`), {
        type:'line',
        data:{
            labels:[],
            datasets:sensors.map(sensor => ({
                label:sensor.label,
                data:[],
                borderColor:sensor.color,
                tension:0.3,
                pointRadius:0
            }))
        },
        options:{
            animation:false,
            maintainAspectRatio:false,
            plugins:{
                legend:{display:false},
                tooltip:{
                    callbacks:{
                        label(ctx) {
                            const sensor = sensors[ctx.datasetIndex];
                            return `${sensor.label}: ${format(ctx.raw)} ${sensor.unit}`;
                        }
                    }
                }
            },
            scales:{x:{display:false},y:{display:false}}
        }
    });
}

function updateTank(index, tank) {
    const data = tank.data;
    const status = document.getElementById(`status-${index}`);
    const gas = gasStatus(data);
    let alarmText = '';

    document.getElementById(`liq-${index}`).style.height = `${gas.level}%`;
    document.getElementById(`gas-${index}`).innerText = gas.text;
    document.getElementById(`gas-${index}`).className = gas.className;

    status.innerText = data ? 'ONLINE' : 'NO DATA';
    status.className = data ? 'online' : 'offline';

    sensors.forEach((sensor, sensorIndex) => {
        const value = data ? data[sensor.key] : null;
        const card = document.getElementById(`card-${sensor.key}-${index}`);

        document.getElementById(`${sensor.key}-${index}`).innerText = `${format(value)} ${sensor.unit}`.trim();
        card.classList.remove('alarm');

        if (isAlarm(sensor, value)) {
            card.classList.add('alarm');
            alarmText = `${sensor.label} ${tank.tankId}`;
        }

        const chartValue = value === null || value === undefined ? null : Number(value);
        charts[index].data.datasets[sensorIndex].data.push(chartValue);
    });

    charts[index].data.labels.push('');

    if (charts[index].data.labels.length > 15) {
        charts[index].data.labels.shift();
        charts[index].data.datasets.forEach(dataset => dataset.data.shift());
    }

    charts[index].update();
    return alarmText;
}

function updateDashboard(tanks) {
    let latestAlarm = '';

    tanks.forEach((tank, index) => {
        const alarm = updateTank(index, tank);
        if (alarm) latestAlarm = alarm;
    });

    document.getElementById('alarmLog').innerText = latestAlarm || 'None';
    document.getElementById('lastUpdate').innerText = new Date().toLocaleTimeString();
    document.getElementById('time').innerText = new Date().toLocaleTimeString();
}

async function fetchDashboard() {
    const startedAt = performance.now();

    try {
        const response = await fetch(dashboardUrl);
        const ping = Math.round(performance.now() - startedAt);

        if (!response.ok) throw new Error(`HTTP ${response.status}`);

        const body = await response.json();
        updateNetwork(true, ping);
        updateDashboard(body.data.tanks);
    } catch (err) {
        updateNetwork(false);
    }
}

function updateNetwork(isOnline, ping = '--') {
    const net = document.getElementById('net');
    const net2 = document.getElementById('net2');

    net.innerText = isOnline ? 'ONLINE' : 'OFFLINE';
    net2.innerText = isOnline ? 'ONLINE' : 'OFFLINE';
    net.className = isOnline ? 'online' : 'offline';
    net2.className = isOnline ? 'online' : 'offline';
    document.getElementById('ping').innerText = ping;
    document.getElementById('ping2').innerText = ping;
}

initialTanks.forEach((tank, index) => {
    renderStaticParts(index);
    createChart(index);
});

updateDashboard(initialTanks);
setInterval(fetchDashboard, 1000);
