<template>
  <div id="overwiew">
    <h1>Overview Company Employees</h1>
    <div id="div">
      <ul v-for="item in users" :key="item.name">
        <div v-if="item.role != 'Applicant'">
          <router-link :to="'/worklist-ui/' + item.name"><b> {{ item.name }} </b> </router-link>
          currently working on:

          <div v-if="item.tasks != null">
            <div v-for="item in item.tasks" :key="item.name">
              {{ item.label }}
            </div>
          </div>
          <div v-else>Currently nothing to do!</div>
        </div>
      </ul>
    </div>

    <h1>Overview Applicants</h1>
    <div id="div">
      <ul v-for="item in users" :key="item.name">
        <div v-if="item.role == 'Applicant'">
           <router-link :to="'/worklist-ui/' + item.name"><b> {{ item.name }} </b> </router-link> is at step {{ item.step }} and currently
          working on:

          <div v-if="item.tasks != null">
            <div v-for="item in item.tasks" :key="item.name">
              {{ item.label }}
            </div>
          </div>
          <div v-else>Currently nothing to do!</div>
        </div>
      </ul>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";

Vue.use(VueAxios, axios);

export default {
  name: "Overview",
  mounted() {
    Vue.axios.get(this.path + "/users").then((resp) => {
      this.users = resp.data;
      console.log(this.users);
    });
  },
  components: {},
  data() {
    return {
      path: "http://abgabe.cs.univie.ac.at:9202",

      users: "",
    };
  },
};
</script>

<style>
#overwiev {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#div {
  margin-top: 20px;
}
</style>
