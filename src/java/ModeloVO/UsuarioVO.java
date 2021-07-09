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
public class UsuarioVO {

    private String usuId, usuLogin, usuPassword, rol;

    public UsuarioVO(String usuId, String rol) {
        this.usuId = usuId;
        this.rol = rol;
    }

    public UsuarioVO(String usuId, String usuLogin, String usuPassword) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
    }

    public UsuarioVO() {
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuId() {
        return usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }
}
