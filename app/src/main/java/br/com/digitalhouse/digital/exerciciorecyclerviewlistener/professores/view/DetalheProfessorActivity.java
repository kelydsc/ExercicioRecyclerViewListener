package br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.R;
import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.model.Professor;

public class DetalheProfessorActivity extends AppCompatActivity {

    //Declaração de atributos
    private TextView textViewNomeDetalhe;
    private TextView textViewCursoDetalhe;
    private TextView textViewConteudoDetalhe;
    private ImageView imageViewBackDetalhe;
    private ImageView imageViewFotoDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_professor);

        initViews();

        //Valido se vmeio alguma coisa na intent
        if (getIntent() != null && getIntent().getExtras() != null) {
            Professor professor = getIntent().getParcelableExtra("PROFESSOR");

            if (professor != null) {
                // Posso usar o professor para mostrar os dados na tela

                retornaDetalheListaProfessores(professor);

                chamaListaNoticia();

            }
        }
    }

    private void initViews() {
        textViewNomeDetalhe = findViewById(R.id.textViewNomeDetalhe);
        textViewCursoDetalhe = findViewById(R.id.textViewCursoDetalhe);
        textViewConteudoDetalhe = findViewById(R.id.textViewConteudoDetalhe);
        imageViewFotoDetalhe = findViewById(R.id.imageViewFotoDetalhe);
        imageViewBackDetalhe = findViewById(R.id.imagemBackDetalheProfessores);
    }

    private void chamaListaNoticia() {
        imageViewBackDetalhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chama a tela de Lista de Professores
                Intent intentListaProfessores = new Intent(
                        DetalheProfessorActivity.this, ProfessorActivity.class);

                startActivity(intentListaProfessores);
            }
        });
    }

    private void retornaDetalheListaProfessores(Professor professor) {

        imageViewFotoDetalhe.setImageResource(professor.getFoto());
        textViewNomeDetalhe.setText(professor.getNome());
        textViewCursoDetalhe.setText(professor.getCurso());

        textViewConteudoDetalhe.setText(
                "3+ years of experience and knowledge in Java" +
                        "\ndevelopment, knowledge of Java programming " +
                        "\nlanguage, frameworks that as JSF, Primefaces and" +
                        "\nBootstrap and development in Java Web as well as " +
                        "\nknowledge of databases as MySQL and SQL and code" +
                        "\nversioning tools that as Git and SVN. Currently teaches " +
                        "\nin the course of Mobile Android.");
    }
}
