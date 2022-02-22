<template>
  <div id="app">
<h1>Report application to company</h1>
<p>
    Enter your first and last name and then write the name of the company you applied to.
</p>
 <div id="margin">
 <label>First and last name:</label>
 <input v-model="firstAndLastName" >
 </div>

 <div id="margin">
 <label>Email:</label>
 <input v-model="email">
 </div>

 <div id="margin">
 <label>Company name:</label>
 <input v-model="cname" >
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
  name: 'ReportApplication',
  components: {
 
  },
    props: ['uiLink', 'user'],
    data() {
    return {
     cname : '',
     firstAndLastName: '',
     email : '',

    };
  },
    methods: {
    submit: function () {
     
      Vue.axios.put(this.uiLink, {companyName: this.cname, applicantName: this.firstAndLastName, email: this.email}).then(response => console.log(response));

      let postPath = "http://abgabe.cs.univie.ac.at:9202" + "/finished/" + this.user + "/" + "ReportApplication";

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
