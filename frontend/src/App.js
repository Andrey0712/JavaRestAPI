import './App.css';
import Navbar from './components/navbar/navbar';
import ProdList from './components/products';
import ProductCreate from './components/products/createProd';
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
          <Route exact path="/create"><ProductCreate /></Route>                  
        </Switch>
      </div>
    </>

  );
}

export default App;
