//copied code from the Student class
//very similar and makes my life easier

public class Worker extends Person{
    private String job;

    public Worker(String firstName, String lastName, String phoneNumber, String job){
        super(firstName, lastName, phoneNumber);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString(){
        return super.toString()+" Occupation:  "+job;
    }
}
