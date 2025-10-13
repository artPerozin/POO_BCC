package Semana7.Domain;

import java.util.ArrayList;
import java.util.List;

import Semana7.Exceptions.EspacoIndisponivelException;
import Semana7.Infra.Animal;
import Semana7.Infra.Aquario;
import Semana7.Infra.Viveiro;

public class Zoologico {
    private List<Animal> animais;
    private List<Viveiro> viveiros;

    public Zoologico() {
        this.animais = new ArrayList<>();
        this.viveiros = new ArrayList<>();
    }

    public void cadastrarViveiro(Viveiro viveiro) {
        this.viveiros.add(viveiro);
    }

    public void cadastrarAnimal(Animal animal) {
        this.animais.add(animal);
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro) throws EspacoIndisponivelException {
        if (!viveiros.contains(viveiro)) {
            return false;
        }

        boolean sucesso = viveiro.adicionarAnimal(animal);
        
        if (!sucesso) {
            throw new EspacoIndisponivelException(
                "Não há espaço disponível no viveiro '" + viveiro.getNome() + 
                "' para alocar o animal '" + animal.getNome() + "'."
            );
        }

        return true;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public List<Viveiro> getViveiros() {
        return viveiros;
    }

    public Aquario[] getOnlyAquarios() {
        List<Aquario> aquarios = new ArrayList<>();
        for (Viveiro v : this.viveiros) {
            if (v instanceof Aquario) {
                aquarios.add((Aquario) v);
            }
        }
        return aquarios.toArray(new Aquario[0]);
    }

    public Viveiro[] getOnlyViveiros() {
        List<Viveiro> filteredViveiros = new ArrayList<>();
        for (Viveiro v : this.viveiros) {
            if (!(v instanceof Aquario)) {
                filteredViveiros.add(v);
            }
        }
        return filteredViveiros.toArray(new Viveiro[0]);
    }
}
