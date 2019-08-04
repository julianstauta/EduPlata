package develop.app.luismiguelpaz.appeduplata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;

public class Simulation extends AppCompatActivity {

    RecyclerView messageList;
    adapter_messages adapter_messages;
    Button option1;
    Button option2;
    story story;
    graph graph;
    node opt1;
    node opt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation );

        messageList = findViewById(R.id.messagelist);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        story = new story(this, getIntent().getExtras().getString("type"));
        graph = story.getLaStory();



        adapter_messages = new adapter_messages(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        messageList.setLayoutManager(l);

        adapter_messages.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                Log.e(">>>>>>>>>>>>>>>>>>>>>", "sfajkdgaykiwsuhajugaj");
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollBar();
            }
        });

        messageList.setAdapter(adapter_messages);

        advanceStory(story.getNodes().get(1));

//        ArrayList<Integer> a = graph.getAdjList().get(0);
//        MessageFlauta mes = new MessageFlauta();
//        String[] str = story.getMessages().get(a.get(0)).split(":");
//        mes.author = "Daniel:";
//        mes.message = str[0];
//
//        adapter_messages.addMessage(mes);
//
//        ArrayList<Integer> a2 = graph.getAdjList().get(1);
//        MessageFlauta mes2 = new MessageFlauta();
//        String[] str2 = story.getMessages().get(a2.get(0)).split(":");
//        mes2.author = str2[0] + ":";
//        mes2.message = str2[1];
//
//        adapter_messages.addMessage(mes2);
//
//
//        paintButtons(1);

        option1.setOnClickListener( e -> {
            if (!option1.getText().toString().equals("Continuar")){
                MessageFlauta m = new MessageFlauta();
                m.author = "Yo:";
                m.message = option1.getText().toString();
                advanceStory(opt1);
            } else{
                Intent i = new Intent(this, Moraleja.class);
                i.putExtra("moraleja", story.getNodes().get(-1).getMessage());
                startActivity(i);
                finish();
            }
        });

        option2.setOnClickListener( e -> {
            MessageFlauta m = new MessageFlauta();
            m.author = "Yo:";
            m.message = option2.getText().toString();
            advanceStory(opt2);
        });

    }

    public void advanceStory(node node){
        ArrayList<node> a = graph.getAdjList().get(node);
        Iterator<node> b = graph.getAdjList().keySet().iterator();
        while (b.hasNext()){

            Log.e("---------------->", b.next().getMessage()+"");
        }
        MessageFlauta mes = new MessageFlauta();
        Log.e("-----------------", a.size()+"");
        String[] str = node.getMessage().split(":");
        if (str.length==2){
            if (str[0].equals("User")){
                str[0] = "Yo";
            }
            mes.author = str[0] + ":";
            mes.message = str[1];
            adapter_messages.addMessage(mes);
        } else {
            mes.message = str[0];
            adapter_messages.addMessage(mes);
        }
        if (a.size() == 0){
            option1.setText("Continuar");
            option2.setVisibility(View.INVISIBLE);
        } else if (a.size() == 1){
            advanceStory(a.get(0));
        } else if (a.size() == 2){
            paintButtons(node);
        }
    }

    public void paintButtons(node node){
        ArrayList<node> a = graph.getAdjList().get(node);
        if (a.size()==2){
            MessageFlauta mes = new MessageFlauta();
            String[] str = a.get(0).getMessage().split(":");
            mes.author = str[0] + ":";
            mes.message = str[1];
            option1.setText(mes.message);
            opt1 = a.get(0);
            String[] str2 = a.get(1).getMessage().split(":");
            option2.setText(str2[1]);
            opt2 = a.get(1);
        } else {
//            MessageFlauta mes = new MessageFlauta();
//            String[] str = story.getMessages().get(a.get(0)+1).split(":");
//            mes.author = str[0] + ":";
//            mes.message = str[1];
//            adapter_messages.addMessage(mes);
//            advanceStory(a.get(0));
        }
    }

    public void setScrollBar(){
        messageList.scrollToPosition(adapter_messages.getItemCount()-1);
    }

}
