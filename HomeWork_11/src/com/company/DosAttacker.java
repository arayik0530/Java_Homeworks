package com.company;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class DosAttacker {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        NetworkService service = new NetworkService(100, "https://www.google.com");

        service.submitTask();

    }

}