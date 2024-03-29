/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  darkMode: ['selector', '[data-mode="dark"]'],

  theme: {
    extend: {
      colors: {
       
     
        "bck-light": "#F6F6F6",
        "component-light-color": "#f3f4f6",
        "component-light-color-2": "#a4a4a4",
        "component-light-color-3":'#fff',
        
        "light-font": '#1F1F1F',
        
    

        "bck-dark": "#202020",
        "component-dark-color":'#2a2a2a',
        "component-dark-color-2":'#464646',
        "component-dark-color-3":'#303030',

        "dark-font": '#fff',
        

        "base-color": "#4caf50",
        "hover-font": "#37BB3B",
        "invisible-component-color":'#00000019'

      },
    }
  },


  plugins: [],
}