<template>
  <div id="app">
<h1>Rate Employee</h1>
<p>
    Rate employee for instance : {{uiLink}}
</p>
<p>
  Please enter a rating in form of ONE letter from F to A, where A is the best and F is the worst
</p>
 <div id="margin">
 <label>Rating:</label>
 <input v-model="rating" >
 </div>


 <div id="margin">
  <router-link :to="'/overview'"><button v-on:click="submit()">Submit</button></router-link>
 </div>
</div>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";

Vue.use(VueAxios, axios);

export default {
  name: 'RateEmployee',
  components: {
 
  },
    props: ['uiLink', 'user'],
    data() {
    return {
     rating: ''
    };
  },
    methods: {
    submit: function () {
     
     Vue.axios.put(this.uiLink, {rating: this.rating}).then(response => console.log(response));
      
      
       let postPath = "http://abgabe.cs.univie.ac.at:9202" + "/finished/" + this.user + "/" + "RateEmployee";

      Vue.axios.post(postPath).then((resp)=>{
        console.log(resp)
      });
      
    }
  },


}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#margin {
    margin-top: 15px;
}
</style>
