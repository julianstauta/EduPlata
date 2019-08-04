package develop.app.luismiguelpaz.appeduplata;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MessageHolder extends RecyclerView.ViewHolder {

    private TextView author;
    private TypeWriter message;

    public MessageHolder(@NonNull View itemView) {
        super(itemView);
        author = (TextView) itemView.findViewById(R.id.author);
        message = (TypeWriter) itemView.findViewById(R.id.message);
    }

    public TextView getAuthor() {
        return author;
    }

    public void setAuthor(TextView author) {
        this.author = author;
    }

    public TypeWriter getMessage() {
        return message;
    }

    public void setMessage(TypeWriter message) {
        this.message = message;
    }
}
