package develop.app.luismiguelpaz.appeduplata;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class adapter_messages extends RecyclerView.Adapter<MessageHolder> {

    List<MessageFlauta> messageFlautas;
    Simulation c;

    public adapter_messages(Simulation c){
        messageFlautas = new ArrayList<>();
        this.c = c;
    }

    public void addMessage(MessageFlauta m){
        messageFlautas.add(m);
        notifyDataSetChanged();
        c.setScrollBar();
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.activity_message_holder, viewGroup, false);
        return new MessageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder messageHolder, int i) {
        messageHolder.getAuthor().setText(messageFlautas.get(i).author);
        if (i == messageFlautas.size()-1){
            messageHolder.getMessage().setCharacterDelay(50);
            messageHolder.getMessage().animateText(messageFlautas.get(i).message);
        } else {
            messageHolder.getMessage().setText(messageFlautas.get(i).message);
        }
    }

    @Override
    public int getItemCount() {
        return messageFlautas.size();
    }
}
