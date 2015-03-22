package com.marverenic.music.instances;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Artist implements Parcelable {

    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() {
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    @SerializedName("artistId")
    public long artistId;
    @SerializedName("artistName")
    public String artistName;

    public Artist(final long artistId, final String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
    }

    private Artist(Parcel in) {
        artistId = in.readLong();
        artistName = in.readString();
    }

    public boolean equals(final Object obj) {
        return this == obj ||
                (obj != null && obj instanceof Artist && artistId == ((Artist) obj).artistId);
    }

    public String toString() {
        return artistName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(artistId);
        dest.writeString(artistName);
    }

}
