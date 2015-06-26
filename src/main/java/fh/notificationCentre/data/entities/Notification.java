package fh.notificationCentre.data.entities;

/**
 * Created by filip on 26.6.15.
 */
public class Notification {

    private String notificationGuid;
    private String deviceGuid;
    private String userGuid;
    private String eventType;
    private String eventSubtype;
    private Double geoferenceLat;
    private Double geoferenceLon;
    private Float geoferenceRadiusMetres;
    private String title;
    private String content;
    private Double eventTimestamp;
    private Double sentTimestamp;

    public String getNotificationGuid() {
        return notificationGuid;
    }

    public void setNotificationGuid(String notificationGuid) {
        this.notificationGuid = notificationGuid;
    }

    public String getDeviceGuid() {
        return deviceGuid;
    }

    public void setDeviceGuid(String deviceGuid) {
        this.deviceGuid = deviceGuid;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventSubtype() {
        return eventSubtype;
    }

    public void setEventSubtype(String eventSubtype) {
        this.eventSubtype = eventSubtype;
    }

    public Double getGeoferenceLat() {
        return geoferenceLat;
    }

    public void setGeoferenceLat(Double geoferenceLat) {
        this.geoferenceLat = geoferenceLat;
    }

    public Double getGeoferenceLon() {
        return geoferenceLon;
    }

    public void setGeoferenceLon(Double geoferenceLon) {
        this.geoferenceLon = geoferenceLon;
    }

    public Float getGeoferenceRadiusMetres() {
        return geoferenceRadiusMetres;
    }

    public void setGeoferenceRadiusMetres(Float geoferenceRadiusMetres) {
        this.geoferenceRadiusMetres = geoferenceRadiusMetres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Double eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public Double getSentTimestamp() {
        return sentTimestamp;
    }

    public void setSentTimestamp(Double sentTimestamp) {
        this.sentTimestamp = sentTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (!notificationGuid.equals(that.notificationGuid)) return false;
        if (!deviceGuid.equals(that.deviceGuid)) return false;
        if (!userGuid.equals(that.userGuid)) return false;
        if (!eventType.equals(that.eventType)) return false;
        if (!eventSubtype.equals(that.eventSubtype)) return false;
        if (!geoferenceLat.equals(that.geoferenceLat)) return false;
        if (!geoferenceLon.equals(that.geoferenceLon)) return false;
        if (!geoferenceRadiusMetres.equals(that.geoferenceRadiusMetres)) return false;
        if (!title.equals(that.title)) return false;
        if (!content.equals(that.content)) return false;
        if (!eventTimestamp.equals(that.eventTimestamp)) return false;
        return sentTimestamp.equals(that.sentTimestamp);

    }

    @Override
    public int hashCode() {
        int result = notificationGuid.hashCode();
        result = 31 * result + deviceGuid.hashCode();
        result = 31 * result + userGuid.hashCode();
        result = 31 * result + eventType.hashCode();
        result = 31 * result + eventSubtype.hashCode();
        result = 31 * result + geoferenceLat.hashCode();
        result = 31 * result + geoferenceLon.hashCode();
        result = 31 * result + geoferenceRadiusMetres.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + eventTimestamp.hashCode();
        result = 31 * result + sentTimestamp.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationGuid='" + notificationGuid + '\'' +
                ", deviceGuid='" + deviceGuid + '\'' +
                ", userGuid='" + userGuid + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventSubtype='" + eventSubtype + '\'' +
                ", geoferenceLat=" + geoferenceLat +
                ", geoferenceLon=" + geoferenceLon +
                ", geoferenceRadiusMetres=" + geoferenceRadiusMetres +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", eventTimestamp='" + eventTimestamp + '\'' +
                ", sentTimestamp='" + sentTimestamp + '\'' +
                '}';
    }
}
