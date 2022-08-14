package br.com.estudo.ecommerce.entities;

public class Email {

    private String message;
    private String title;
    private String destinatario;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Email{" +
                "message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", destinatario='" + destinatario + '\'' +
                '}';
    }
}
