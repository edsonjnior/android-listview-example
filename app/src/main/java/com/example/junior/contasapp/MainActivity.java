package com.example.junior.contasapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.junior.contasapp.adapters.LancamentoListAdapter;
import com.example.junior.contasapp.enums.TipoLancamento;
import com.example.junior.contasapp.models.Lancamento;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TITULO_ITEM = "com.example.junior.contasapp.item.titulo";
    public static final String DESCRICAO_ITEM = "com.example.junior.contasapp.item.descricao";
    public static final String TIPO_ITEM = "com.example.junior.contasapp.item.tipo";
    public static final String VALOR_ITEM = "com.example.junior.contasapp.item.valor";
    public static final String DATA_ITEM = "com.example.junior.contasapp.item.data";

    private ListView listView;
    private LancamentoListAdapter adapter;
    private List<Lancamento> lista = new ArrayList<Lancamento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lista de lançamentos");

        listView = findViewById(R.id.listView);

        try {
            lista.add(new Lancamento("Salário", "Quinzena 1", 2000d, TipoLancamento.CREDITO, "20/12/2018", R.drawable.ic_money_in));
            lista.add(new Lancamento("Empréstimo", "Recebimento de empréstimo", 100d, TipoLancamento.CREDITO, "20/12/2018", R.drawable.ic_money_in));
            lista.add(new Lancamento("Supermercado", "Compras Comercial Carvalho", 20d, TipoLancamento.DEBITO, "20/12/2018", R.drawable.ic_money_out));
            lista.add(new Lancamento("Padaria", "Bolo salgado", 10d, TipoLancamento.DEBITO, "20/12/2018", R.drawable.ic_money_out));
            lista.add(new Lancamento("Gasolina", "Posto Frei Serafim", 40d, TipoLancamento.DEBITO, "20/12/2018", R.drawable.ic_money_out));
            lista.add(new Lancamento("Lanche", "Lanche no IFPI", 4.5d, TipoLancamento.DEBITO, "20/12/2018", R.drawable.ic_money_out));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        adapter = new LancamentoListAdapter(this, lista);
        listView.setAdapter(adapter);
    }
}
