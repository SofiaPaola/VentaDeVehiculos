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
public class DatosPersonalesVO {
    private String datId, usuId, datNombre, datApellido, datTipoDocumento,
            datNumeroDocumento, datTelefono, datCorreo;

    public DatosPersonalesVO() {
    }

    public DatosPersonalesVO(String datId, String usuId, String datNombre, 
            String datApellido, String datTipoDocumento, String datNumeroDocumento, 
            String datTelefono, String datCorreo) {
        this.datId = datId;
        this.usuId = usuId;
        this.datNombre = datNombre;
        this.datApellido = datApellido;
        this.datTipoDocumento = datTipoDocumento;
        this.datNumeroDocumento = datNumeroDocumento;
        this.datTelefono = datTelefono;
        this.datCorreo = datCorreo;
    }

    public String getDatId() {
        return datId;
    }

    public void setDatId(String datId) {
        this.datId = datId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getDatNombre() {
        return datNombre;
    }

    public void setDatNombre(String datNombre) {
        this.datNombre = datNombre;
    }

    public String getDatApellido() {
        return datApellido;
    }

    public void setDatApellido(String datApellido) {
        this.datApellido = datApellido;
    }

    public String getDatTipoDocumento() {
        return datTipoDocumento;
    }

    public void setDatTipoDocumento(String datTipoDocumento) {
        this.datTipoDocumento = datTipoDocumento;
    }

    public String getDatNumeroDocumento() {
        return datNumeroDocumento;
    }

    public void setDatNumeroDocumento(String datNumeroDocumento) {
        this.datNumeroDocumento = datNumeroDocumento;
    }

    public String getDatTelefono() {
        return datTelefono;
    }

    public void setDatTelefono(String datTelefono) {
        this.datTelefono = datTelefono;
    }

    public String getDatCorreo() {
        return datCorreo;
    }

    public void setDatCorreo(String datCorreo) {
        this.datCorreo = datCorreo;
    }
}
