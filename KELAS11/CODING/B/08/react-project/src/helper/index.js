export function getRandomNumber(init, final)
{
    return Math.floor(Math.random() * (final-init) + (init + 1));
}