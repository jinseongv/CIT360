private static final HttpURLConnection getConnection(URL entries) throws InterruptedException{
    int retry = 0;
    boolean delay = false;
    do {
        if (delay) {
            Thread.sleep(RETRY_DELAY_MS);
        }
        HttpURLConnection connection = (HttpURLConnection)entries.openConnection();
        switch (connection.getResponseCode()) {
            case HttpURLConnection.HTTP_OK:
                log.fine(entries + " **OK**");
                return connection; // **EXIT POINT** fine, go on
            case HttpURLConnection.HTTP_GATEWAY_TIMEOUT:
                log.warning(entries + " **gateway timeout**");
                break;// retry
            case HttpURLConnection.HTTP_UNAVAILABLE:
                log.warning(entries + "**unavailable**");
                break;// retry, server is unstable
            default:
                log.severe(entries + " **unknown response code**.");
                break; // abort
        }
        // we did not succeed with connection (or we would have returned the connection).
        connection.disconnect();
        // retry
        retry++;
        log.warning("Failed retry " + retry + "/" + RETRIES);
        delay = true;

    } while (retry < RETRIES);

    log.severe("Aborting download of dataset.");

}
