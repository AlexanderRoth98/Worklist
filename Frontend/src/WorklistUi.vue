<template>
  <div id="worklist-ui">
    <h1>Hello, {{ urlData }}! This is to do:</h1>
       <ul v-for="item in users" :key="item.name">   
        <div v-if="item.name == urlData">
          <div v-if="item.tasks != null">
            <div id="margin" v-for="item in item.tasks" :key="item.name">
             <router-link :to="{name: item.label, params: {uiLink : item.uiLink, user: urlData}}"> {{ item.label }} </router-link> 
                  <router-link to="/overview"> <button v-on:click="giveBack(item.label)">Give Back</button> </router-link>
            </div>
          </div>
          <div v-else>Currently nothing to do!</div>
        </div>
      </ul>
      <div>
         <router-link to="/overview"> <button>Back To Overview Page</button> </router-link>
      </div>
  </div>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";

Vue.use(VueAxios, axios);
export default {
  name: "WorklistUi",
  components: {},
  mounted() {
    Vue.axios.get(this.path + "/users").then((resp) => {
      this.users = resp.data;
      console.log(this.users);
    });
    this.urlData = this.$route.params.user;
  },

  methods: {
    giveBack: function (label) {
     
     let postPath = this.path +"/giveBack/" +this.urlData + "/" + label;

      Vue.axios.post(postPath).then((resp)=>{
        console.log(resp)
      });
      
    }
  },

  data() {
    return {
      path: "http://abgabe.cs.univie.ac.at:9202",

      urlData: "",
      users: "",
    };
  },
};
</script>

<style>
#worklist-ui {
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
