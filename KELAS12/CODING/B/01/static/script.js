document.getElementById("contactForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const message = document.getElementById("message").value.trim();

  if (name && email && message) {
    document.getElementById("formMsg").textContent = "Terima kasih, pesan Anda telah dikirim!";
    this.reset();
  } else {
    document.getElementById("formMsg").textContent = "Mohon lengkapi semua bidang.";
  }
});
