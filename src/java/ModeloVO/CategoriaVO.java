/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Sofia Paola
 */
public class CategoriaVO {
    private String catId, catTipo;   

    public CategoriaVO(String catId, String catTipo) {
        this.catId = catId;
        this.catTipo = catTipo;
    }

    public CategoriaVO() {
    }
    
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatTipo() {
        return catTipo;
    }

    public void setCatTipo(String catTipo) {
        this.catTipo = catTipo;
    }
}
