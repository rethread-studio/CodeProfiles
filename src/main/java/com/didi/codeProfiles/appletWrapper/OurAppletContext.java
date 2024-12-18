package com.didi.codeProfiles.appletWrapper;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;

class OurAppletContext implements AppletContext {
    private Toolkit ourToolkit;

    OurAppletContext(Toolkit paramToolkit) {
        this.ourToolkit = paramToolkit;
    }

    public Image getImage(URL paramURL) {
        return this.ourToolkit.getImage(paramURL);
    }

    public AudioClip getAudioClip(URL paramURL) {
//        return new OurAudioClip(paramURL);
        return null;
    }

    public Applet getApplet(String paramString) {
        return null;
    }

    public Enumeration getApplets() {
        return null;
    }

    public void showDocument(URL paramURL) {
    }

    public void showDocument(URL paramURL, String paramString) {
    }

    public void showStatus(String paramString) {
    }

    @Override
    public void setStream(String key, InputStream stream) throws IOException {

    }

    @Override
    public InputStream getStream(String key) {
        return null;
    }

    @Override
    public Iterator<String> getStreamKeys() {
        return null;
    }
}



/* Location:           C:\Users\W Bradford Paley\Desktop\stampCycle.jar

 * Qualified Name:     com.metrowerks.OurAppletContext

 * JD-Core Version:    0.7.0.1

 */
