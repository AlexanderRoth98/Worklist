<template>
  <div id="app">
<h1>Confirm report</h1>
<p>
    Confirm report of instance: {{uiLink}}
</p>
<p>
    Yes -> to send confirmation email!
</p>
<p>
    No -> to send email denying the report!
</p>
 
 <div id="margin">
  <router-link :to="'/overview'"><button v-on:click="submit()">Yes</button></router-link>
 <router-link :to="'/overview'"><button id="margin-left" v-on:click="no()">No</button></router-link>
 </div>


</div>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";

Vue.use(VueAxios, axios);

export default {
  name: 'ConfirmReport',
  components: {
 
  },
    props: ['uiLink', 'user'],
    data() {
    return {
     
    };
  },
    methods: {
    submit: function () {
     
     Vue.axios.put(this.uiLink, {confirmed: "true"}).then(response => console.log(response));

       let postPath = "http://abgabe.cs.univie.ac.at:9202" + "/finished/" + this.user + "/" + "ConfirmReport";

      Vue.axios.post(postPath).then((resp)=>{
        console.log(resp)
      });
      
      
    },

    no: function (){
    Vue.axios.put(this.uiLink, {confirmed: "false"}).then(response => console.log(response));

      let postPath = "http://abgabe.cs.univie.ac.at:9202" + "/finished/" + this.user + "/" + "ConfirmReport";

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

#margin-left {
    margin-left: 10px;

}
</style>
