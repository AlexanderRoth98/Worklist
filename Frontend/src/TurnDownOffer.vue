<template>
  <div id="app">
<h1>Turn Down Contract</h1>
<p>
    Herby I confirm that I am turning down the contract:
</p>

 <div id="margin">
  <router-link :to="'/overview'"><button v-on:click="submit()">Turn Down</button></router-link>
 </div>
</div>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";

Vue.use(VueAxios, axios);

export default {
  name: 'TurnDownOffer',
  components: {
 
  },
    props: ['uiLink', 'user'],
    data() {
    return {
    
    };
  },
    methods: {
    submit: function () {
     
     Vue.axios.put(this.uiLink).then(response => console.log(response));
            let postPath = "http://abgabe.cs.univie.ac.at:9202" + "/finished/" + this.user + "/" + "TurnDownOffer";

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
