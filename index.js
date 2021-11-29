//function that calculates solar brightness with latitude, day of the year, and time of day
function solar_brightness(latitude, day, time) {
    // calculate the solar declination
    var solar_declination = 0.409 * Math.sin(2 * Math.PI * (284 + day) / 365);
    // calculate the solar time
    var solar_time = (time * 15) + (4 * latitude) - (60 * solar_declination);
    // calculate the solar altitude
    var solar_altitude = Math.asin(Math.sin(Math.PI / 180 * solar_declination) * Math.sin(Math.PI / 180 * latitude) + Math.cos(Math.PI / 180 * solar_declination) * Math.cos(Math.PI / 180 * latitude) * Math.cos(Math.PI / 180 * solar_time));
    // calculate the solar azimuth
    var solar_azimuth = Math.acos((Math.sin(Math.PI / 180 * solar_declination) - Math.sin(Math.PI / 180 * latitude) * Math.sin(Math.PI / 180 * solar_altitude)) / (Math.cos(Math.PI / 180 * latitude) * Math.cos(Math.PI / 180 * solar_altitude)));
    // calculate the solar brightness
    var solar_brightness = (Math.sin(Math.PI / 180 * solar_altitude) * Math.sin(Math.PI / 180 * solar_azimuth) + Math.cos(Math.PI / 180 * solar_altitude) * Math.cos(Math.PI / 180 * solar_azimuth) * Math.cos(Math.PI / 180 * solar_time));
    // return the solar brightness
    return solar_brightness;
}
