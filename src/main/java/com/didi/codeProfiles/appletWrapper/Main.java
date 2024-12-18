package com.didi.codeProfiles.appletWrapper;

import picocli.CommandLine;

import java.applet.Applet;
import java.awt.*;
import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static String[] args = {
            "com.didi.codeProfiles.CodeProfiles",
            "filename=src/main/java/com/didi/codeProfiles/CodeProfiles.java",
            "width=1280",
            "height=720",
    };

    public static void main(String[] args) {
        new CommandLine(new RunApplet()).execute(args);
    }

    public static void appletFunc(CountDownLatch latch) {
        String[] paramArrayOfString = args;
        Hashtable localHashtable = new Hashtable();
        for (int i = 1; i < paramArrayOfString.length; i++) {
            int j = paramArrayOfString[i].indexOf("=");
            if ((j > 0) && (j < paramArrayOfString[i].length() - 1)) {
                localHashtable.put(
                        paramArrayOfString[i].substring(0, j).toUpperCase(),
                        paramArrayOfString[i].substring(j + 1)
                );
            } else {
                System.out.println("can't parse arg: \"" + paramArrayOfString[i] + "\"");
            }
        }
        String str1 = paramArrayOfString[0];
        Applet localApplet = null;
        try {
            try {
                Class localClass = Class.forName(str1);
                localApplet = (Applet) localClass.newInstance();
            } catch (ClassNotFoundException localClassNotFoundException) {
                System.out.println("can't find Applet: " + str1);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        Rectangle localRectangle = new Rectangle();
        localRectangle.setBounds(0, 0,
                Integer.parseInt((String) localHashtable.get("WIDTH"), 10),
                Integer.parseInt((String) localHashtable.get("HEIGHT"), 10));
        if (localApplet != null) {
            AppletFrame.startApplet(
                    localApplet,
                    localApplet.toString(),
                    localHashtable,
                    localRectangle.x,
                    localRectangle.y,
                    localRectangle.width,
                    localRectangle.height,
                    latch
            );
        }
    }

    @CommandLine.Command(name = "applet", mixinStandardHelpOptions = true, version = "0.1")
    private static class RunApplet implements Runnable {
        private final CountDownLatch latch = new CountDownLatch(1);

        @Override
        public void run() {
            appletFunc(latch);
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
