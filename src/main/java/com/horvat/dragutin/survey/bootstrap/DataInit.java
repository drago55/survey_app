package com.horvat.dragutin.survey.bootstrap;

import com.horvat.dragutin.survey.controllers.SurveyController;
import com.horvat.dragutin.survey.enums.EnumInputType;
import com.horvat.dragutin.survey.enums.LikertScaleEnum;
import com.horvat.dragutin.survey.enums.MatrixScaleEnum;
import com.horvat.dragutin.survey.enums.QuestionType;
import com.horvat.dragutin.survey.model.*;
import com.horvat.dragutin.survey.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInit implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataInit.class);

    private final InputTypeRepository inputTypeRepository;
    private final QuestionRepository questionRepository;
    private final OptionGroupRepository optionGroupRepository;
    private final OptionsRepository optionsRepository;
    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;

    private Set<Question> questions;

    private User user;
    private Survey survey;

    public DataInit(InputTypeRepository inputTypeRepository,
                    QuestionRepository questionRepository,
                    OptionGroupRepository optionGroupRepository,
                    OptionsRepository optionsRepository,
                    UserRepository userRepository,
                    SurveyRepository surveyRepository)
    {
        this.inputTypeRepository = inputTypeRepository;
        this.questionRepository = questionRepository;
        this.optionGroupRepository = optionGroupRepository;
        this.optionsRepository = optionsRepository;
        this.userRepository = userRepository;
        this.surveyRepository = surveyRepository;
    }


    @Override
    public void run(String... args) {
        //Creating empty set for questions
        questions = new HashSet<>();

        //Adding attributes
       addInputTypes();
       addOptionGroup();
       createUser();

       //Adding questions
       addDichotomousQuestion();
       addClosedQuestionToDB();
       addMultiChoiceQuestions();
       addRatingScaleQuestion();
       addLikertScaleQuestion();
       addOpenEndedQuestion();
       addMatrixQuestion();

       //Creating survey
       createSurvey();

        logger.info("Created mock survey {} ", survey);

    }

    public void createSurvey(){
        survey = new Survey();
        survey.setName("Demo Survey");
        survey.setCreated(LocalDateTime.now());
        Set<User> users = new HashSet<>();
        users.add(user);
        survey.setUser(users);
        survey.setQuestions(questions);
        surveyRepository.save(survey);
        surveyRepository.flush();
    }

    public void createUser(){
        user = new User();
        user.seteMail("pero.peric@live.com");
        user.setFirstName("Pero");
        user.setLastName("Peric");
        userRepository.save(user);
        userRepository.flush();
    }

    public void addOptionGroup(){
        for (MatrixScaleEnum matrixScaleEnum: MatrixScaleEnum.values()) {
            OptionGroup optionGroup =  new OptionGroup(matrixScaleEnum.getDescription(),
                    matrixScaleEnum.ordinal(), QuestionType.MATRIX_QUESTIONS);
            optionGroupRepository.save(optionGroup);
        }

        for (LikertScaleEnum likertScaleEnum: LikertScaleEnum.values()) {
            OptionGroup optionGroup =  new OptionGroup(likertScaleEnum.getDescription(),
                    likertScaleEnum.ordinal(), QuestionType.LIKERT_SCALE);
            optionGroupRepository.save(optionGroup);
        }

        for (int i = 0; i < 10; i++) {
            String name = "";
            if(i == 0){
                name = "Not at all likely";
            }

            if(i==9){
                name = "Extremely likely";
            }

            OptionGroup optionGroup =  new OptionGroup(name,i,QuestionType.RATING_SCALE);
            optionGroupRepository.save(optionGroup);
        }

        optionGroupRepository.flush();

    }

    public void addInputTypes(){

        for (EnumInputType inputType: EnumInputType.values()) {
            InputType typeCheckBox = new InputType(inputType.getDescription(), inputType.ordinal());
            inputTypeRepository.save(typeCheckBox);
        }
        inputTypeRepository.flush();
    }

    public void addOpenEndedQuestion(){
        Options noOption = new Options("free input");
        optionsRepository.save(noOption);
        Set<Options> options = new HashSet<>();
        options.add(noOption);
        optionsRepository.flush();

        Question openEndedQuestion = new Question();
        openEndedQuestion.setText("Why don't you eat ice cream  at Fictional Ice Cream Parlour?");
        openEndedQuestion.setAllowMultipleOptions(Boolean.FALSE);
        openEndedQuestion.setQuestionType(QuestionType.OPEN_ENDED_QUESTIONS);
        openEndedQuestion.setInputType(inputTypeRepository.findByCode(EnumInputType.FREE_INPUT.ordinal()));

        openEndedQuestion.setOptions(options);

        questions.add(openEndedQuestion);

        questionRepository.save(openEndedQuestion);
    }

    public void addMatrixQuestion(){
        Options matrixScaleOptionOne = new Options("Ease of learning");
        Options matrixScaleOptionTwo = new Options("Ease of use");
        Options matrixScaleOptionTree = new Options("Power of completeness");
        Options matrixScaleOptionFour = new Options("Quality of technical support");
        Options matrixScaleOptionFive = new Options("Quality of documentation");

        Set<OptionGroup> optionGroupSet = optionGroupRepository.findAllByQuestionType(QuestionType.MATRIX_QUESTIONS);

        matrixScaleOptionOne.setOptionGroup(optionGroupSet);
        matrixScaleOptionTwo.setOptionGroup(optionGroupSet);
        matrixScaleOptionTree.setOptionGroup(optionGroupSet);
        matrixScaleOptionFour.setOptionGroup(optionGroupSet);
        matrixScaleOptionFive.setOptionGroup(optionGroupSet);

        Set<Options> options = new HashSet<>();
        options.add(matrixScaleOptionOne);
        options.add(matrixScaleOptionTwo);
        options.add(matrixScaleOptionTree);
        options.add(matrixScaleOptionFour);
        options.add(matrixScaleOptionFive);

        for (Options option: options){
            optionsRepository.save(option);
        }

        optionsRepository.flush();

        Question matrixQuestion = new Question();
        matrixQuestion.setText("Please rate our software on each of the following items.");
        matrixQuestion.setAllowMultipleOptions(Boolean.FALSE);
        matrixQuestion.setQuestionType(QuestionType.MATRIX_QUESTIONS);
        matrixQuestion.setInputType(inputTypeRepository.findByCode(EnumInputType.RADIO_BUTTON.ordinal()));

        matrixQuestion.setOptions(options);

        questions.add(matrixQuestion);

        questionRepository.save(matrixQuestion);
    }

    public void addLikertScaleQuestion(){
        Options likertScale = new Options("LikertScale");

        Set<OptionGroup> optionGroupSet = optionGroupRepository.findAllByQuestionType(QuestionType.LIKERT_SCALE);
        likertScale.setOptionGroup(optionGroupSet);
        Set<Options> options = new HashSet<>();
        options.add(likertScale);

        optionsRepository.save(likertScale);

        optionsRepository.flush();

        Question likertScaleQuestion = new Question();
        likertScaleQuestion.setText("How satisfied or dissatisfied are you with the quality of customer support at LeadQuizzes?");
        likertScaleQuestion.setAllowMultipleOptions(Boolean.FALSE);
        likertScaleQuestion.setQuestionType(QuestionType.LIKERT_SCALE);
        likertScaleQuestion.setInputType(inputTypeRepository.findByCode(EnumInputType.CHECK_BOX.ordinal()));

        likertScaleQuestion.setOptions(options);

        questions.add(likertScaleQuestion);

        questionRepository.save(likertScaleQuestion);
    }

    public void addRatingScaleQuestion(){
        Options scale = new Options("Scale");

        Set<OptionGroup> optionGroupSet = optionGroupRepository.findAllByQuestionType(QuestionType.RATING_SCALE);

        scale.setOptionGroup(optionGroupSet);
        Set<Options> options = new HashSet<>();
        options.add(scale);

        optionsRepository.save(scale);

        optionsRepository.flush();

        Question ratingScaleQuestion = new Question();
        ratingScaleQuestion.setText("On a scale from 0-10, how likely are you to recommend this product to a friend?");
        ratingScaleQuestion.setAllowMultipleOptions(Boolean.FALSE);
        ratingScaleQuestion.setQuestionType(QuestionType.RATING_SCALE);
        ratingScaleQuestion.setInputType(inputTypeRepository.findByCode(EnumInputType.CHECK_BOX.ordinal()));
        ratingScaleQuestion.setOptions(options);

        questions.add(ratingScaleQuestion);

        questionRepository.save(ratingScaleQuestion);
    }

    public void addDichotomousQuestion(){
        Options noOption = new Options("No");
        Options yesOption = new Options("Yes");
        Set<Options> options = new HashSet<>();
        options.add(noOption);
        options.add(yesOption);

        for (Options option: options) {
            optionsRepository.save(option);
        }

        optionsRepository.flush();

        Question dichotomousQuestion = new Question();
        dichotomousQuestion.setText("Are you a marketing agency or consultant?");
        dichotomousQuestion.setAllowMultipleOptions(Boolean.FALSE);
        dichotomousQuestion.setQuestionType(QuestionType.DICHOTOMOUS_YES_NO);
        dichotomousQuestion.setInputType(inputTypeRepository.findByCode(EnumInputType.CHECK_BOX.ordinal()));

        dichotomousQuestion.setOptions(options);

        questions.add(dichotomousQuestion);

        questionRepository.save(dichotomousQuestion);
    }

    public void addMultiChoiceQuestions(){
        Options firstOption = new Options("Batman.");
        Options secondOption = new Options("Superman.");
        Options thirdOption = new Options("Iron Man.");
        Options forthOption = new Options("Spider-Man.");
        Options fifthOption = new Options("Other.");
        Set<Options> options = new HashSet<>();
        options.add(firstOption);
        options.add(secondOption);
        options.add(thirdOption);
        options.add(forthOption);
        options.add(fifthOption);
        for (Options option: options) {
            optionsRepository.save(option);
        }

        optionsRepository.flush();

        Question multiChoiceQuestion = new Question();
        multiChoiceQuestion.setText("Who's your favorite superhero?");
        multiChoiceQuestion.setAllowMultipleOptions(Boolean.TRUE);
        multiChoiceQuestion.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        multiChoiceQuestion.setInputType(inputTypeRepository.findByCode(EnumInputType.CHECK_BOX.ordinal()));

        multiChoiceQuestion.setOptions(options);

        questions.add(multiChoiceQuestion);

        questionRepository.save(multiChoiceQuestion);
    }


    public void addClosedQuestionToDB(){

        Options firstOption = new Options("I don't like the flavours.");
        Options secondOption = new Options("It's too expensive.");
        Options thirdOption = new Options("The service is bad.");
        Options forthOption = new Options("I don't like the ice cream.");
        Options fifthOption = new Options("It's too far from my house.");
        Options sixthOption = new Options("I don't know.");
        Set<Options> options = new HashSet<>();
        options.add(firstOption);
        options.add(secondOption);
        options.add(thirdOption);
        options.add(forthOption);
        options.add(fifthOption);
        options.add(sixthOption);

        for (Options option: options) {
            optionsRepository.save(option);
        }
        optionsRepository.flush();

        Question closeEndedQuestion = new Question();
        closeEndedQuestion.setText("Why don't you eat ice cream  at Fictional Ice Cream Parlour? \n (Chose at least one answer.)");
        closeEndedQuestion.setAllowMultipleOptions(Boolean.TRUE);
        closeEndedQuestion.setQuestionType(QuestionType.CLOSE_ENDED_QUESTIONS);
        closeEndedQuestion.setInputType(inputTypeRepository.findByCode(EnumInputType.CHECK_BOX.ordinal()));

        closeEndedQuestion.setOptions(options);

        questions.add(closeEndedQuestion);

        questionRepository.save(closeEndedQuestion);

    }

}
