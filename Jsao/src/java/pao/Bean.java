/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pao;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author fabio
 */
@ManagedBean
@RequestScoped
public class Bean {

    /**
     * Creates a new instance of Bean
     */
    public Bean() {
    }

    private String text;

    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        results.add("São Paulo");
        results.add("Rio de Janeiro");
        results.add("Amazonas");
        results.add("Bahia");
        results.add("Minas Gerais");

        return results;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
