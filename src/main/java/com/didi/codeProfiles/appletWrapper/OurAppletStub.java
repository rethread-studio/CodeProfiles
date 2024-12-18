package com.didi.codeProfiles.appletWrapper;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

class OurAppletStub implements AppletStub {
    private Hashtable paramTable;
    private AppletContext appletContext;
    private URL codeBase;
    private URL documentBase;

    OurAppletStub(AppletContext paramAppletContext, Hashtable paramHashtable) {
        this.appletContext = paramAppletContext;
        this.paramTable = paramHashtable;
    }

    public boolean isActive() {
        return true;
    }

    public URL getDocumentBase() {
        if (this.documentBase == null) {
            try {
                File localFile = new File("killme");
                this.documentBase = new URL("file", "", localFile.getAbsolutePath().toString().substring(0, localFile.getAbsolutePath().toString().length() - 6));
            } catch (MalformedURLException localMalformedURLException) {
            }
        }
        return this.documentBase;
    }

    public URL getCodeBase() {
        if (this.codeBase == null) {
            try {
                String fileString = new File("killme").getCanonicalPath();
                this.codeBase = new URL("file", "", fileString.substring(0, fileString.length() - 6));  //  hack pointer to development environment, not real codebase; TODO: put real resources back
            } catch (MalformedURLException localMalformedURLException) {
            } catch (IOException e) {
            }
        }
        return this.codeBase;
    }

    public String getParameter(String paramString) {
        return (String) this.paramTable.get(paramString.toUpperCase());
    }

    public AppletContext getAppletContext() {
        return this.appletContext;
    }

    public void appletResize(int paramInt1, int paramInt2) {
    }
}
