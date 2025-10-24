export function getRandomNumber(init, final, exp=0)
{
    return Math.floor(Math.random() * (final-init) * (Math.pow(10, exp)) + (init + 1) );
}