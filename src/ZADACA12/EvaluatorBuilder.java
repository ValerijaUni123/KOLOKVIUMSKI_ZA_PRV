package ZADACA12;

public class EvaluatorBuilder {

    private static final Evaluator hasCriminalRecord = x -> !x.hasCriminalRecord();
    private static final Evaluator hasMoreExperience = x -> x.getEmploymentYears() >= 10;
    private static final Evaluator hasMoreCreditScore = x -> x.getCreditScore() >= 500;

    public static Evaluator build(Evaluator.TYPE type) throws InvalidEvaluation {
        if(type.toString().equals("NO_CRIMINAL_RECORD")){
            return hasCriminalRecord;
        }
        else if(type.toString().equals("MORE_EXPERIENCE")){
            return hasMoreExperience;
        }
        else if(type.toString().equals("MORE_CREDIT_SCORE")){
            return hasMoreCreditScore;
        }
        else if(type.toString().equals("NO_CRIMINAL_RECORD_AND_MORE_EXPERIENCE")){
            return new BiEvaluator(hasCriminalRecord, hasMoreExperience);
        }
        else if(type.toString().equals("MORE_EXPERIENCE_AND_MORE_CREDIT_SCORE")){
            return new BiEvaluator(hasMoreExperience, hasMoreCreditScore);
        }
        else if(type.toString().equals("NO_CRIMINAL_RECORD_AND_MORE_CREDIT_SCORE")){
            return new BiEvaluator(hasCriminalRecord, hasMoreCreditScore);
        }
        else{
            throw new InvalidEvaluation();
        }
    }
}
