package develop.app.luismiguelpaz.appeduplata;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class story {

    private graph laStory;

    private HashMap<Integer, node> nodes; // La moraleja es -1

    private String type;

    public story(Simulation act, String type) {
        nodes = new HashMap<Integer, node>();
        this.type = type;
        try {
            readNodes(act);
            readGraph(act);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al leer los archivos, contacte al administrador");
        }
    }

    public void readGraph(Simulation act) throws IOException {
        AssetManager assetManager = act.getAssets();
        BufferedReader br = new BufferedReader(new InputStreamReader(assetManager.open("graph"+type+".txt")));

        String st = br.readLine();
        int n = Integer.parseInt(st);
        laStory = new graph(n, nodes);
        while ((st = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(st, " ");
            laStory.addEdge(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }

        br.close();
    }

    public void readNodes(Simulation act) throws IOException {
        AssetManager assetManager = act.getAssets();
        String[] str = assetManager.list("");
        for (int i = 0; i < str.length; i++) {
            Log.e("-----------------", assetManager.list("")[i]+"");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(assetManager.open("hash"+type+".txt")));

        String st;
        while ((st = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(st, "=");
            nodes.put(Integer.parseInt(token.nextToken()), new node(token.nextToken().trim()));
        }

        br.close();
    }

    public graph getLaStory() {
        return laStory;
    }

    public void setLaStory(graph laStory) {
        this.laStory = laStory;
    }

    public HashMap<Integer, node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, node> nodes) {
        this.nodes = nodes;
    }
}