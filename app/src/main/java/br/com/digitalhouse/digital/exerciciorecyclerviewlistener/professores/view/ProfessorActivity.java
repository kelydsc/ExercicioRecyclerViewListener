package br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.R;
import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.adapters.RecyclerViewProfessorAdapter;
import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.model.Professor;

public class ProfessorActivity extends AppCompatActivity implements RecyclerViewClickListener {

    //Atributos
    private RecyclerView recyclerView;
    private RecyclerViewProfessorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        // Inicializamos as views
        recyclerView = findViewById(R.id.recyclerViewProfessores);

        //por padrão nasce na vertical
        // Adiciona o layout manager ao recyclerview
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Adiciona o adapter ao recyclerview
        adapter = new RecyclerViewProfessorAdapter(getProfessor(),this);

        recyclerView.setAdapter(adapter);

    }

    // REtorna lista de contatos para recycleriew
    private List<Professor> getProfessor() {

        List<Professor> professores = new ArrayList<>();

        professores.add(new Professor("Jéssica Milena","Mobile Android",R.drawable.jessica));
        professores.add(new Professor("Fabio Tadashi","Mobile Android",R.drawable.fabio));
        professores.add(new Professor("Guilherme","Mobile Android",R.drawable.guilherme));
        professores.add(new Professor("Victor Caldas","Mobile Android",R.drawable.victor));
        professores.add(new Professor("Tairo Roberto","Mobile Android",R.drawable.tairo));
        professores.add(new Professor("Hugo Rosso","Marketing Digital",R.drawable.victor));
        professores.add(new Professor("Hendy Almeida","FullStack",R.drawable.victor));
        professores.add(new Professor("Vinícius","FullStack",R.drawable.victor));
        professores.add(new Professor("Filipe","Mobile IOS",R.drawable.victor));
        professores.add(new Professor("Victor Caldas","Mobile Android",R.drawable.victor));

        return  professores;
    }

    // Método para escutar evento de click em recyclerview
    @Override
    public void onClick(Professor professor) {

        Intent intent = new Intent(this,DetalheProfessorActivity.class);
        intent.putExtra("PROFESSOR",professor);//passando todos os dados do Array para outra Actitivty

        //teste para enviar o resultado do Array
        //startActivityForResult(intent, 1);
        //
        startActivity(intent);
    }
}

