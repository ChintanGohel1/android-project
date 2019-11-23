package com.inch2inch.genericService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Switch;

import com.inch2inch.api.GetAPI;
import com.inch2inch.api.PostAPI;

public class GenericService {

    private static final String PATH_API_HOST = "http://10.0.2.2/inch2inch/";

    public static <T> String save(T t, String apiName) {
	String response = "";
	JSONObject jsonObject;

	try {
	    jsonObject = jsonParsing(t);

	    response = new PostAPI()
		    .execute(PATH_API_HOST + apiName, jsonObject.toString())
		    .get();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	} catch (ExecutionException e) {
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    e.printStackTrace();
	} catch (JSONException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	}
	return response;
    }

    public static JSONObject get(String apiName) {

	JSONObject jsonObject = null;
	try {
	    jsonObject = new JSONObject(new GetAPI()
		    .execute(PATH_API_HOST + apiName).get());
	} catch (InterruptedException e) {
	    e.printStackTrace();
	} catch (ExecutionException e) {
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    e.printStackTrace();
	} catch (JSONException e) {
	    e.printStackTrace();
	}

	return jsonObject;

    }

    public static boolean isGetter(Method method) {
	if (Modifier.isPublic(method.getModifiers())
		&& method.getParameterTypes().length == 0) {
	    if (method.getName().matches("^get[A-Z].*")
		    && !method.getReturnType().equals(void.class))
		return true;
	    if (method.getName().matches("^is[A-Z].*")
		    && method.getReturnType().equals(boolean.class))
		return true;
	}
	return false;
    }

    public static boolean isSetter(Method method) {
	if (Modifier.isPublic(method.getModifiers())
		&& method.getParameterTypes().length == 1) {
	    if (method.getName().matches("^set[A-Z].*")
		    && method.getReturnType().equals(void.class))
		return true;
	    // if (method.getName().matches("^is[A-Z].*")
	    // && method.getReturnType().equals(boolean.class))
	    // return true;
	}
	return false;
    }

    public static <T> JSONObject jsonParsing(T t)
	    throws IllegalArgumentException, JSONException,
	    IllegalAccessException, InvocationTargetException {
	JSONObject jsonObject = new JSONObject();
	Field[] fields = t.getClass().getDeclaredFields();
	Method[] methods = t.getClass().getMethods();

	for (Method method : methods) {
	    flag: for (Field field : fields) {
		if (field.getName().equalsIgnoreCase(
			method.getName().substring(3))
			&& isGetter(method)) {
		    jsonObject.put(field.getName(), method.invoke(t));
		    break flag;
		}

	    }
	}
	return jsonObject;

    }

    public static <S, T> S convertJsonObjectTOJavaObject(Class<S> targetClass,
	    JSONObject jsonObject) {
	S s = null;
	try {
	    s = targetClass.newInstance();
	    Field[] fields = s.getClass().getDeclaredFields();
	    Method[] methods = s.getClass().getMethods();
	    List<Method> setMethods = new ArrayList<Method>();
	    // Method[] setMethods = new Method[fields.length];

	    for (Method method : methods) {
		if (isSetter(method)) {
		    setMethods.add(method);
		}
	    }

	    // JSONObject jsonObject = new JSONObject(sourceJsonString);

	    for (Method method : setMethods) {
		flag: for (Field field : fields) {
		    if (field.getName().equalsIgnoreCase(
			    method.getName().substring(3))) {
			if (method.getParameterTypes()[0].isPrimitive()) {

			    if (method.getParameterTypes()[0].getName().equals(
				    "int")) {
				int i = Integer.valueOf(jsonObject.get(
					field.getName()).toString());
				method.invoke(s, i);
			    } else if (method.getParameterTypes()[0].getName()
				    .equals("double")) {
				double d = Double.valueOf(jsonObject.get(
					field.getName()).toString());
				method.invoke(s, d);
			    } else if (method.getParameterTypes()[0].getName()
				    .equals("long")) {
				long l = Long.valueOf(jsonObject.get(
					field.getName()).toString());
				method.invoke(s, l);
			    } else if (method.getParameterTypes()[0].getName()
				    .equals("short")) {
				short shrt = Short.valueOf(jsonObject.get(
					field.getName()).toString());
				method.invoke(s, shrt);
			    } else if (method.getParameterTypes()[0].getName()
				    .equals("char")) {
				char c = (Character) jsonObject.get(field
					.getName());
				method.invoke(s, c);
			    } else if (method.getParameterTypes()[0].getName()
				    .equals("boolean")) {
				boolean b = Boolean.valueOf(jsonObject.get(
					field.getName()).toString());
				method.invoke(s, b);
			    } else if (method.getParameterTypes()[0].getName()
				    .equals("float")) {
				float f = Float.valueOf(jsonObject.get(
					field.getName()).toString());
				method.invoke(s, f);
			    } else if (method.getParameterTypes()[0].getName()
				    .equals("boolean")) {
				boolean b = Boolean.valueOf(jsonObject.get(
					field.getName()).toString());
				method.invoke(s, b);
			    }

			    //
			    // method.invoke(
			    // s,
			    // converToPrimitive(
			    // method.getParameterTypes()[0],
			    // jsonObject.get(field.getName()).toString()));
			} else {
			    method.invoke(
				    s,
				    converToWrapper(
					    method.getParameterTypes()[0],
					    jsonObject.get(field.getName())));
			}
			// method.invoke(s, jsonObject.get(field.getName()));
			break flag;
		    }

		}
	    }
	    System.out.println(s.toString());
	} catch (JSONException e) {
	    e.printStackTrace();
	} catch (InstantiationException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	}
	return s;

    }

    private static <T> T converToWrapper(Class<T> clazz, Object object) {
	return clazz.cast(object);
    }

   
    // private static <S , T> S convertJsonObjectTOJavaObject(Class<S>
    // targetClass,
    // JSONObject jsonObject,Class<T> beanType) {
    // JSONArray jsonArray = new JSONArray(jsonObject.toString());
    // S s;
    // try {
    // s = targetClass.newInstance();
    // } catch (InstantiationException e1) {
    // e1.printStackTrace();
    // } catch (IllegalAccessException e1) {
    // e1.printStackTrace();
    // }
    // for(int i=0 ; i < jsonArray.length();i++){
    // T t = null;
    // try {
    // t = beanType.newInstance();
    // Field[] fields = t.getClass().getDeclaredFields();
    // Method[] methods = t.getClass().getMethods();
    //
    // // JSONObject jsonObject = new JSONObject(sourceJsonString);
    //
    // for (Method method : methods) {
    // flag: for (Field field : fields) {
    // if (field.getName().equalsIgnoreCase(
    // method.getName().substring(3))
    // && isSetter(method)) {
    // method.invoke(t, jsonArray.getJSONObject(i).get(field.getName()));
    // break flag;
    // }
    //
    // }
    // }
    // System.out.println(t.toString());
    // } catch (JSONException e) {
    // e.printStackTrace();
    // } catch (InstantiationException e) {
    // e.printStackTrace();
    // } catch (IllegalAccessException e) {
    // e.printStackTrace();
    // } catch (IllegalArgumentException e) {
    // e.printStackTrace();
    // } catch (InvocationTargetException e) {
    // e.printStackTrace();
    // }
    //
    //
    // }
    //
    // }
}
