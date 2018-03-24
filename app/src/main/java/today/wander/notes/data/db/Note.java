package today.wander.notes.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

@Entity/*(tableName = "tbl_note")*/
public class Note implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long noteId;

    private String title;

    private String text;

    private long timestamp;


    public Note() {
        timestamp=System.currentTimeMillis();
    }

    @Ignore
    public Note(String title, String text) {
        this.title=title;
        this.text = text;
        this.timestamp=System.currentTimeMillis();
    }

    protected Note(Parcel in) {
        noteId = in.readLong();
        title = in.readString();
        text = in.readString();
        timestamp = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(noteId);
        dest.writeString(title);
        dest.writeString(text);
        dest.writeLong(timestamp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
