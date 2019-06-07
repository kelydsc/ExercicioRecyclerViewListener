package br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Professor implements Parcelable {

    //atributos
    private String nome;
    private String curso;
    private int foto;

    //construtor vazio
    public Professor() {
    }

    //construtor especifico
    public Professor(String nome, String curso, int foto) {
        this.nome = nome;
        this.curso = curso;
        this.foto = foto;
    }

    protected Professor(Parcel in) {
        nome = in.readString();
        curso = in.readString();
        foto = in.readInt();
    }

    public static final Creator<Professor> CREATOR = new Creator<Professor>() {
        @Override
        public Professor createFromParcel(Parcel in) {
            return new Professor(in);
        }

        @Override
        public Professor[] newArray(int size) {
            return new Professor[size];
        }
    };

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(curso);
        parcel.writeInt(foto);
    }
}