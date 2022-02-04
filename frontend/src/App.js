import './App.css';
import Navbar from './components/navbar/navbar';
import ProdList from './components/products';
import {Switch,Route} from 'react-router-dom';
import HomePage from './components/home';



function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <Switch>
          <Route exact path="/"><HomePage /></Route>
          <Route exact path="/products"><ProdList /></Route> 
                              
        </Switch>
      </div>
    </>

  );
}

export default App;
