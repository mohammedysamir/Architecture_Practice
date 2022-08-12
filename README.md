# Architecture_Practice
Android architecture patterns practice {MCV,MVP,MVVM}
This Repository is initiated to practice 3 android architectures, explanation is provided by [Ahmed Azz](https://www.youtube.com/playlist?list=PLb6ZzJ93PVwqU5kxWftiLY_iHNZvfoUM2) channel.

### MVC:
  - Stands for Model-View-Controller.
  - Traditional architecture for mobile and web applications.
  - Define Model for data storage (data class, APIs, DB).
  - Depends on composition between the **Controller** and the **View** -> controller has reference of its view.
  - Android project affect this architecture to define both the controller and the view dependently (drawback).
  - Suits small applications.
  
  ##### Diagram
  ![mvc](https://user-images.githubusercontent.com/47453799/184301878-4b60d83c-bcd4-441b-beaf-3190829f94b2.png)

  
### MVP:
  - Stands for Model-View-Presenter.
  - Try to separate computations from the View.
  - Computations are delegated to the **Presenter**.
  - Suits **middle-size** projects.
  - We need to define an interface for each View and then implement it.
    - This is the Preseneter responsibilities.
    - Presenter will get View's inputs using those functions declared in the interface.
    - Send data to model
    - Get updated data from model.
    - Send them back to the View (also we could do computations in presenter)
  - How the presenter will send data back to the view?
    - We need to define an interface for each view that will define functions with parameter of type model.
    - Those funcitons will be implemented in the View class -> get model object and update View's UI.
    
   ##### Diagram
   ![mvp](https://user-images.githubusercontent.com/47453799/184303336-d6f42a67-ab94-4612-bd97-4b4cc9ea437a.png)

### MVVM
  - Most recent and most used architecture in **large-size** applications.
  - Based on Observer pattern.
  - Views are separated from the ViewModel.
  - ViewModel can't communicate directly with the Models.
  - Repositories will deal with Models (remote, local), update or fetch data to ViewModels.
  - Logic can be delegated to either ViewModel or the Repository.
    - For **DIP and Strategy pattern**: We declare repository interface then implement it, ViewModel will have a reference to repository interface to update or fetch data.
    - View must have a reference to ViewModel -> can be done through composition or XML <data> tag.
    - ViewModel will get View's inputs then handle them to repository object defined in it.
    - Repository object will update model and fetch new updated data using **MutableLiveData<T>** and return it to the VM.
    - VM will get repo's MutableLiveData<T>, do computations and return final data to View as LiveData<T>.
    - The View will **observe** ViewModel's data using:

      ```
      vmObj.observe(this,Observe{ liveDataObj->
        //update UI using liveDataObj's data
      })
      ```
  
  ##### Diagrams:
  ![general mvvm](https://user-images.githubusercontent.com/47453799/184304839-059b3888-12f2-43b0-b2ce-b81bfeeee096.png)
  
  ![detailed mvvm](https://user-images.githubusercontent.com/47453799/184304818-47ff0569-d5d4-4e73-a6e3-d3e59346b2a3.png)
  
  ![mvvm](https://user-images.githubusercontent.com/47453799/184304834-dc86600e-750b-47c7-ae86-c3e6c9edd10f.png)

Hope my explanation was easy to understand 😊✌
  
