# BMI Calculator

BMI calculator is simple application developed following Kotlin, mvvm design pattern 

## Model-View-ViewModel (MVVM)

- View (Activity/Fragment)
    - Only views or view related code will exist here
    - Views like Layout, Views, Containers etc.
    - It has no information from where the data flows or travers
- ViewModel
    - It consists with the Business Logic
    - All the business logic is implemented here
    - And it will work as a BRIDGE between the View and Model
    - It will receive and pass the data to View/Model vice-verse 
    - It has the Information of where the data flows or traverse
    - Recommend to implement a single ViewModel if the same data is used in several view or fragments
    - Recommend to implement several ViewModels if different/specific data is used in different/specific views or fragments
- Model
    - Similar to View, it also has no clue of where the data flows or traverse
    - It works with Data storage (Local data like Room/SQLite) or Remote(Web-Services)
