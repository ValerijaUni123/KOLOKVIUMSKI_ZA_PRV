package ZADACA12;

public class BiEvaluator implements Evaluator{
    private Evaluator a;
    private Evaluator b;

    public BiEvaluator(Evaluator a, Evaluator b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean evaluate(Applicant applicant) {
        return a.evaluate(applicant) && b.evaluate(applicant);
    }
}
