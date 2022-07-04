package hello.hellospring.controller;

//웹 등록 화면에서 데이터를 전달 받을 폼 객체
public class MemberForm {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
