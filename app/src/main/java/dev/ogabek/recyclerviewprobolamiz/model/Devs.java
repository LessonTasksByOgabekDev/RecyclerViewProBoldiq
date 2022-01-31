package dev.ogabek.recyclerviewprobolamiz.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Devs implements Parcelable {

    private int img;
    private String name, job;

    public Devs(int img, String name, String job) {
        this.img = img;
        this.name = name;
        this.job = job;
    }

    protected Devs(Parcel in) {
        img = in.readInt();
        name = in.readString();
        job = in.readString();
    }

    public static final Creator<Devs> CREATOR = new Creator<Devs>() {
        @Override
        public Devs createFromParcel(Parcel in) {
            return new Devs(in);
        }

        @Override
        public Devs[] newArray(int size) {
            return new Devs[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getJob() {
        return job;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(img);
        parcel.writeString(name);
        parcel.writeString(job);
    }
}
