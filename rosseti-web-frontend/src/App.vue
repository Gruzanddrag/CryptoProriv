<template>
  <v-app>
    <Navbar />
    <v-content>
     <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import Navbar from './components/Navbar.vue';
// import signInUp from './components/signInUp.vue';

export default {
  name: 'App',

  components: {
    Navbar,
    // signInUp,

  },

  data: () => ({
  }),
};
</script>
