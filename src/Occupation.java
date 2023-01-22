//copied code from the Student class
//very similar and makes my life easier

public class Occupation extends Person{
    private String job;

    public Occupation(String firstName, String lastName, String phoneNumber, String job){
        super(firstName, lastName, phoneNumber);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString(){
        return super.toString()+" Location:  "+job;
    }
}
