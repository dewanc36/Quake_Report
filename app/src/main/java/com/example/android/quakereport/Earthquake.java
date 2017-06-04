package com.example.android.quakereport;

/**
 * Created by dewan on 5/28/17.
 */

public class Earthquake {
    private double mag;
    private String loc;
    private String date;
    private String eqUrl;

    public String getEqUrl() {
        return eqUrl;
    }

    public void setEqUrl(String eqUrl) {
        this.eqUrl = eqUrl;
    }

    public Earthquake(double mag, String loc, String date, String eqUrl) {

        this.mag = mag;
        this.loc = loc;
        this.date = date;
        this.eqUrl = eqUrl;

    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
