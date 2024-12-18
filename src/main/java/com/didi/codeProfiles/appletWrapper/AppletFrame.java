package com.didi.codeProfiles.appletWrapper;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;

public class AppletFrame extends Frame implements WindowListener {
    public static Window window;
    private static CountDownLatch exitLatch;

    public AppletFrame(String paramString) {
        super(paramString);
        addWindowListener(this);
    }

    public static void startApplet(Applet paramApplet, String paramString, Hashtable paramHashtable,
                                   int paramInt1, int paramInt2, int paramInt3, int paramInt4,
                                   CountDownLatch latch) {
        exitLatch = latch;
        OurAppletContext localOurAppletContext = new OurAppletContext(paramApplet.getToolkit());
        OurAppletStub localOurAppletStub = new OurAppletStub(localOurAppletContext, paramHashtable);
        paramApplet.setStub(localOurAppletStub);
        AppletFrame localAppletFrame = new AppletFrame(paramString + " - Applet Window");
        window = new Window(localAppletFrame);
        window.setBackground(Color.black);
        window.add("Center", paramApplet);
        window.pack();
        window.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        paramApplet.setSize(paramInt3, paramInt4);
        window.show();
        window.requestFocus();
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent paramAnonymousKeyEvent) {
                if (exitLatch != null) {
                    exitLatch.countDown();
                }
                Runtime.getRuntime().exit(0);
            }
        });
        paramApplet.init();
        paramApplet.start();
    }

    public void windowActivated(WindowEvent paramWindowEvent) {
    }

    public void windowClosed(WindowEvent paramWindowEvent) {
    }

    public void windowClosing(WindowEvent paramWindowEvent) {
        if (exitLatch != null) {
            exitLatch.countDown();
        }
        Runtime.getRuntime().exit(0);
    }

    public void windowDeactivated(WindowEvent paramWindowEvent) {
    }

    public void windowDeiconified(WindowEvent paramWindowEvent) {
    }

    public void windowIconified(WindowEvent paramWindowEvent) {
    }

    public void windowOpened(WindowEvent paramWindowEvent) {
    }
}
