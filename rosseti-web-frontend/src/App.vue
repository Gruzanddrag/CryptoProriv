<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
      </div>
      <v-spacer></v-spacer>
    </v-app-bar>

    <v-main>
      <router-link to="/">Home</router-link>
      <router-link to="/about">About</router-link>
      <router-link to="/signInUp">Login</router-link>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
// import HelloWorld from './components/HelloWorld';

export default {
  name: 'App',

  components: {
    // HelloWorld,
  },

  data: () => ({
    //
  }),
};
</script>
