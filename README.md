# G525SWM_CW2_scyyz4
## Refactor for code
### 1. **Use Simple Factory Pattern to expose the object creation logic to the actors.** Method getActor() is created in ActorFactory.java to generate different actors. 

### 2. **Use MVC modern to keep the model away from the GUI implementation.** FXML document is used for GUI design. Main process happens in model and use controller to handle events. For example, 
```
ScoreBoard.java
ScoreBoardController.java
ScoreBoard.fxml
```

### 2. **Encapsulate Fields to retain private variables.** Get and procedures are used to provide public access to private member variables. Besides. For instance,
``
static final double IMG_SIZE=40;
static final double MOVEMENT;
``
### 3. **Extract methods from a larger block of code and create a new method to perform them.** The body of Animal.java is too long. So, I extracted death( ),insideBoundary( ), keepSpeed( ) from the big block and recall them in act( ).  

### 3. Use Singleton pattern to generate one(only one) ScoreBoard instance> So that players' information will be read uniformly by a singleton object.

### 4. **Use Symbolic Content instead of Magic Number.** For example, when count the number of ends that frogger have reached, I used `static final double NUM_OF_END=5;` 

### 5. **Decreace duplicated code.** I extracted the code that used for scene switch to a new class `SceneSwitch.java` and use method `sceneJump()` to implement it.   

### 6. **Classify classes into different packages according to their function.**

## Addtional functionality
### 1. **Permanent high score list.** When a player complete the game, system will record his score in `score.txt` and compare his socre with histry player scores. If he can enter Top5 list, he will get the right to enter his name  and his information will be written in `sortedScore.txt`.

### 2.**Player Lives.** At the beginning of the game, each player has five lives. If they lose all the lives, they lose the game. 

### 3. **Different levels.** 
- Initially, player has the choice to choose `Easy Level` or `Normal Level`. The normal level Hawaiian style, the frogger should avoid vehicles in the dessert and across the ocean by boat. By the way, there are angry sharks in sea, you can only skip them when they hide under water otherwise you will lose your life.
- `Portal:` A portal will appear randomly on the map.
- `Secret Level:` Player can enter a hidden level when the forgger triggers the Portal. When player enters new level successful, his score  is added to the previous level but have another new five lives. 

### 4. **Information Page**. Player can choose to read the information about this game at the beginning of the game and then go back to index page.

### 5. **UI Design.** Import custom fonts and stylesheet.

### 6. **Game elements.**

## JUnit Tests
### 1. Exception Test
Verify that whether the file path is correct(Eg. EndTest.java, SceneSwitchTest.java)

### 2. Input Value Test
Handle incorrect input situation (Eg. ScoreBoard.java, AnimalTest.java)





