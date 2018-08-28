package com.dms.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ExpandableListView elvCompra = (ExpandableListView) findViewById(R.id.elvCompra);

        // cria os grupos
        List<String> lstGrupos = new ArrayList<>();
        lstGrupos.add("Doces");
        lstGrupos.add("Legumes");
        lstGrupos.add("Outros");

        // cria os itens de cada grupo
        List<Produto> lstDoces = new ArrayList<>();
        lstDoces.add(new Produto("Pacote de bala", 4.5));
        lstDoces.add(new Produto("Pacote de chiclete", 3.5));
        lstDoces.add(new Produto("Bolo de chocolate", 50.0));

        List<Produto> lstLegumes = new ArrayList<>();
        lstLegumes.add(new Produto("Alface", 0.5));
        lstLegumes.add(new Produto("Tomate", 2.5));

        List<Produto> lstProdutos = new ArrayList<>();
        lstProdutos.add(new Produto("Chave de Fenda", 7.5));

        // cria o "relacionamento" dos grupos com seus itens
        HashMap<String, List<Produto>> lstItensGrupo = new HashMap<>();
        lstItensGrupo.put(lstGrupos.get(0), lstDoces);
        lstItensGrupo.put(lstGrupos.get(1), lstLegumes);
        lstItensGrupo.put(lstGrupos.get(2), lstProdutos);

        // cria um adaptador (BaseExpandableListAdapter) com os dados acima
        Adapter adaptador = new Adapter(this, lstGrupos, lstItensGrupo);
        // define o apadtador do ExpandableListView
        elvCompra.setAdapter(adaptador);

    }
}
