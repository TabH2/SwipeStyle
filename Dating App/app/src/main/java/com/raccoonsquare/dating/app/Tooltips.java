package com.raccoonsquare.dating.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;

import com.raccoonsquare.dating.R;
import com.raccoonsquare.dating.constants.Constants;

public class Tooltips extends Application implements Constants, Parcelable {

    private Context ctx;
    private SharedPreferences sharedPref;

    private Boolean show_push_notifications_request = true;
    private Boolean show_otp_tooltip = true;
    private Boolean show_loc_tooltip = true;
    private Boolean show_capture_video_time_tooltip = true;

    private Boolean show_login_create_tooltip = true;

    public Tooltips() {

        this.sharedPref = App.getInstance().getSharedPreferences(App.getInstance().getResources().getString(R.string.settings_file), Context.MODE_PRIVATE);
    }

    public void setShowLoginCreateTooltip(Boolean show_login_create_tooltip) {

        this.show_login_create_tooltip = show_login_create_tooltip;
    }

    public Boolean isAllowShowLoginCreateTooltip() {

        return this.show_login_create_tooltip;
    }

    public void setShowOtpTooltip(Boolean show_otp_tooltip) {

        this.show_otp_tooltip = show_otp_tooltip;
    }

    public Boolean isAllowShowOtpTooltip() {

        return this.show_otp_tooltip;
    }

    public void setShowLocTooltip(Boolean show_loc_tooltip) {

        this.show_loc_tooltip = show_loc_tooltip;
    }

    public Boolean isAllowShowLocTooltip() {

        return this.show_loc_tooltip;
    }

    public void setShowCaptureVideoTimeTooltip(Boolean show_follow_tooltip) {

        this.show_capture_video_time_tooltip = show_follow_tooltip;
    }

    public Boolean isAllowShowCaptureVideoTimeTooltip() {

        return this.show_capture_video_time_tooltip;
    }

    public void setShowPushNotificationsRequest(Boolean push_notifications_request) {

        this.show_push_notifications_request = push_notifications_request;
    }

    public Boolean isAllowShowPushNotificationsRequest() {

        return this.show_push_notifications_request;
    }

    public void readTooltipsSettings() {

        this.setShowOtpTooltip(sharedPref.getBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_otp_verification), true));
        this.setShowLocTooltip(sharedPref.getBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_loc_access), true));
        this.setShowCaptureVideoTimeTooltip(sharedPref.getBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_capture_video_time), true));
        this.setShowPushNotificationsRequest(sharedPref.getBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_push_notifications_request), true));
        this.setShowPushNotificationsRequest(sharedPref.getBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_push_notifications_request), true));

        this.setShowLoginCreateTooltip(sharedPref.getBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_login_create), true));
    }

    public void saveTooltipsSettings() {

        sharedPref.edit().putBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_otp_verification), this.isAllowShowOtpTooltip()).apply();
        sharedPref.edit().putBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_loc_access), this.isAllowShowLocTooltip()).apply();
        sharedPref.edit().putBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_capture_video_time), this.isAllowShowCaptureVideoTimeTooltip()).apply();
        sharedPref.edit().putBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_push_notifications_request), this.isAllowShowPushNotificationsRequest()).apply();

        sharedPref.edit().putBoolean(App.getInstance().getResources().getString(R.string.settings_account_tooltip_login_create), this.isAllowShowLoginCreateTooltip()).apply();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeValue(this.show_otp_tooltip);
        dest.writeValue(this.show_loc_tooltip);
        dest.writeValue(this.show_capture_video_time_tooltip);
        dest.writeValue(this.show_push_notifications_request);
    }

    protected Tooltips(Parcel in) {

        this.show_otp_tooltip = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.show_loc_tooltip = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.show_capture_video_time_tooltip = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.show_push_notifications_request = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Creator<Tooltips> CREATOR = new Creator<Tooltips>() {
        @Override
        public Tooltips createFromParcel(Parcel source) {
            return new Tooltips(source);
        }

        @Override
        public Tooltips[] newArray(int size) {
            return new Tooltips[size];
        }
    };
}
