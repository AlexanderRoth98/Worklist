import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Overview from './Overview.vue'
import WorklistUi from './WorklistUi.vue'
import ReportApplication from './ReportApplication.vue'
import ConfirmReport from './ConfirmReport.vue'
import RateApplication from './RateApplication.vue'
import AcceptOffer from './AcceptOffer.vue'
import SignContract from './SignContract.vue'
import TurnDownOffer from './TurnDownOffer.vue'
import RateEmployee from './RateEmployee.vue'
import RateCompany from './RateCompany.vue'

Vue.config.productionTip = false
Vue.use(VueRouter)

const routes = [
  { path: '/overview', component: Overview },
  { path: '/', component: Overview },
  { path: '/worklist-ui/:user?', component: WorklistUi},
  { path: '/ReportApplication', name:'ReportApplication', component: ReportApplication, props: true},
  { path: '/ConfirmReport', name:'ConfirmReport', component: ConfirmReport, props: true},
  { path: '/RateApplication', name:'RateApplication', component: RateApplication, props: true},
  { path: '/AcceptOffer', name:'AcceptOffer', component: AcceptOffer, props: true},
  { path: '/SignContract', name:'SignContract', component: SignContract, props: true},
  { path: '/TurnDownOffer', name:'TurnDownOffer', component: TurnDownOffer, props: true},
  { path: '/RateEmployee', name:'RateEmployee', component: RateEmployee, props: true},
  { path: '/RateCompany', name:'RateCompany', component: RateCompany, props: true},
  
];

const router = new VueRouter({
  routes,
  mode: 'history',
  base: '/~rotha98/ws21/assignment3c/worklist'
})
new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
