package com.company;

import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionEstablisher implements Runnable {

    private static int count = 0;

    private String addressUrl;

    private int status;

    public ConnectionEstablisher(String addressUrl) {

        this.addressUrl = addressUrl;
        this.run();
    }

    @Override
    public void run() {


        try {
            URL url = new URL(addressUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            status = connection.getResponseCode();
        }

        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(((status == 200) ? "response.status -> ok" : "response.status -> error") + " Thread: " +
                Thread.currentThread().getName() + ",  count of connections: " + ++count);
    }
}
